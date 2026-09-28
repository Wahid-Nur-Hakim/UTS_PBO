package com.mycompany.tokoalhafizh;

import controller.CrudProduk;
import java.util.Scanner;
import view.Menu;

public class TokoAlHafizh {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Menu menu = new Menu(scanner);
        CrudProduk crudProduk = new CrudProduk(scanner, menu);

        crudProduk.jalankanProgram();
    }
}