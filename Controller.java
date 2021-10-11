package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import zad1.ListOfProducts;
import zad1.Product;

import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;

public class Controller {

    @FXML
    private TextField txtDescpription;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextArea txtShow;

    @FXML
    private Button btnSortProducts;

    @FXML
    private Button btnShowProducts;

    @FXML
    private Button btnAveragePrice;

    @FXML
    private Button btnAddToList;

    @FXML
    private Button btnGroupByCategory;

    ListOfProducts<Product> listOfProducts = new ListOfProducts<>();

    @FXML
    void btnAddToListOnAction(ActionEvent event) {
        Product product = new Product();
        product.setCategory(txtCategory.getText());
        product.setInvDescription(txtDescpription.getText());
        product.setPrice(parseDouble(txtPrice.getText()));
        listOfProducts.add(product);
    }

    @FXML
    void btnAveragePriceOnAction(ActionEvent event) {

       double x = listOfProducts.getProducts().stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(Double.NaN);
        txtShow.setText(String.valueOf(x));

    }

    @FXML
    void btnGroupByCategoryOnAction(ActionEvent event) {
        String[] s = {""};
        listOfProducts.getProducts().stream()
                .collect(Collectors.groupingBy(Product::getCategory))
                .forEach((x,y)-> s[0] +=x+ " " + y.toString()+'\n');
        txtShow.setText(s[0]);

    }

    @FXML
    void btnShowProductsOnAction(ActionEvent event) {
        String[] s = {""};
       listOfProducts.getProducts().stream()
               .filter(x->x.getPrice()>parseDouble(txtPrice.getText()))
               .forEach(x-> s[0] +=x.toString());
       txtShow.setText(s[0]);


    }

    @FXML
    void btnSortProductsOnAction(ActionEvent event) {
        listOfProducts.getProducts().stream()
                .sorted(Comparator.comparingDouble(x->x.getPrice()));
    }



    @FXML
    void txtCategoryOnAction(ActionEvent event) {

    }

    @FXML
    void txtDescriptionOnAction(ActionEvent event) {

    }

    @FXML
    void txtPriceOnAction(ActionEvent event) {

    }

}
