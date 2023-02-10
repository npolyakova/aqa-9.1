package ru.json;

import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        JSONObject jsonCat = new JSONObject();
        jsonCat.put("name", "Izzy");
        jsonCat.put("breed", "Siamese");

        JSONObject jsonOwner = new JSONObject();
        jsonOwner.put("text", "owner");
        jsonOwner.put("name", "Colin Wilcox");
        jsonOwner.put("list", List.of("1", "2", "3"));

        jsonCat.put("owner", jsonOwner);

        JSONObject jsonAddress = new JSONObject();
        jsonAddress.put("street", "Fleet Street");
        jsonAddress.put("house", "5");

        jsonOwner.put("address", jsonAddress);

        System.out.println(jsonCat);

//        {
//           text: owner
//            name: Colin Wilcox
//            address: {
//            street:...
//            house:...
//            }
//        };

        //Чтение
        FileReader fr = new FileReader("src/main/resources/1.json");
        Scanner sc = new Scanner(fr);
        JSONObject newObject = new JSONObject(sc.nextLine());

        System.out.println(newObject);
    }
}
