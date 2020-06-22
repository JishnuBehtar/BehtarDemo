package com.learning.behtardemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ItemAdapter adapter;
    ArrayList<ProductListDataModel> productListDataModels = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        productListDataModels = getList();

        RecyclerView rcvList = findViewById(R.id.rcv_list);
        adapter = new ItemAdapter(this, productListDataModels);
        rcvList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rcvList.setAdapter(adapter);
    }


    private ArrayList<ProductListDataModel> getList() {


        String json = "{\"responce\":\"true\",\"top_selling_product\":[{\"product_id\":\"35536\",\"product_name\":\"lays american style cream n onion potato chips 100g\",\"product_name_arb\":\"\",\"product_description_arb\":\"\",\"category_id\":\"6\",\"product_description\":null,\"deal_price\":\"\",\"start_date\":\"\",\"start_time\":\"\",\"end_date\":\"\",\"end_time\":\"\",\"price\":\"32.9\",\"mrp\":\"35\",\"product_image\":\"https:\\/\\/s3.ap-south-1.amazonaws.com\\/sagarbehtarimages\\/images\\/sku\\/879002924\\/thumbnail\\/879002924.jpg\",\"status\":\"\",\"in_stock\":\"1\",\"unit_value\":null,\"unit\":null,\"increament\":\"1\",\"rewards\":null,\"stock\":\"\",\"title\":\"Foods\"},{\"product_id\":\"34309\",\"product_name\":\"bhagyalakshmi gram flour 500g\",\"product_name_arb\":\"\",\"product_description_arb\":\"\",\"category_id\":\"2\",\"product_description\":null,\"deal_price\":\"\",\"start_date\":\"\",\"start_time\":\"\",\"end_date\":\"\",\"end_time\":\"\",\"price\":\"49\",\"mrp\":\"52\",\"product_image\":\"https:\\/\\/s3.ap-south-1.amazonaws.com\\/sagarbehtarimages\\/images\\/sku\\/880000238\\/thumbnail\\/880000238_.jpg\",\"status\":\"\",\"in_stock\":\"1\",\"unit_value\":null,\"unit\":null,\"increament\":\"1\",\"rewards\":null,\"stock\":\"\",\"title\":\"Staples\"},{\"product_id\":\"35980\",\"product_name\":\"nandini ghee 500ml\",\"product_name_arb\":\"\",\"product_description_arb\":\"\",\"category_id\":\"1\",\"product_description\":null,\"deal_price\":\"\",\"start_date\":\"\",\"start_time\":\"\",\"end_date\":\"\",\"end_time\":\"\",\"price\":\"243.08\",\"mrp\":\"245\",\"product_image\":\"https:\\/\\/s3.ap-south-1.amazonaws.com\\/sagarbehtarimages\\/images\\/sku\\/878000072\\/thumbnail\\/878000072.jpg\",\"status\":\"\",\"in_stock\":\"1\",\"unit_value\":null,\"unit\":null,\"increament\":\"1\",\"rewards\":null,\"stock\":\"\",\"title\":\"Oil & Ghee\"},{\"product_id\":\"41970\",\"product_name\":\"nandini goodlife uht long life milk mrp 24\",\"product_name_arb\":\"\",\"product_description_arb\":\"\",\"category_id\":\"3\",\"product_description\":null,\"deal_price\":\"\",\"start_date\":\"\",\"start_time\":\"\",\"end_date\":\"\",\"end_time\":\"\",\"price\":\"74.4\",\"mrp\":\"80\",\"product_image\":\"https:\\/\\/s3.ap-south-1.amazonaws.com\\/sagarbehtarimages\\/images\\/sku\\/8906036673961\\/thumbnail\\/front.jpeg\",\"status\":\"\",\"in_stock\":\"1\",\"unit_value\":null,\"unit\":null,\"increament\":\"1\",\"rewards\":null,\"stock\":\"\",\"title\":\"Fresh\"},{\"product_id\":\"34196\",\"product_name\":\"aashirvaad superior mp atta 1kg\",\"product_name_arb\":\"\",\"product_description_arb\":\"\",\"category_id\":\"2\",\"product_description\":null,\"deal_price\":\"\",\"start_date\":\"\",\"start_time\":\"\",\"end_date\":\"\",\"end_time\":\"\",\"price\":\"50.4185\",\"mrp\":\"57\",\"product_image\":\"https:\\/\\/s3.ap-south-1.amazonaws.com\\/sagarbehtarimages\\/images\\/sku\\/880000281\\/thumbnail\\/880000281.jpeg\",\"status\":\"\",\"in_stock\":\"1\",\"unit_value\":null,\"unit\":null,\"increament\":\"1\",\"rewards\":null,\"stock\":\"\",\"title\":\"Staples\"},{\"product_id\":\"36620\",\"product_name\":\"tata salt mrp 20\",\"product_name_arb\":\"\",\"product_description_arb\":\"\",\"category_id\":\"2\",\"product_description\":null,\"deal_price\":\"\",\"start_date\":\"\",\"start_time\":\"\",\"end_date\":\"\",\"end_time\":\"\",\"price\":\"17\",\"mrp\":\"19\",\"product_image\":\"https:\\/\\/s3.ap-south-1.amazonaws.com\\/sagarbehtarimages\\/images\\/sku\\/8904043901015\\/thumbnail\\/Front.jpg\",\"status\":\"\",\"in_stock\":\"1\",\"unit_value\":null,\"unit\":null,\"increament\":\"1\",\"rewards\":null,\"stock\":\"\",\"title\":\"Staples\"}]}";
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray dataArray = jsonObject.getJSONArray("top_selling_product");

            for (int i = 0; i < dataArray.length(); ++i) {
                JSONObject object = dataArray.getJSONObject(i);
                ProductListDataModel model = new ProductListDataModel();

                model.setMrp(object.optString("mrp"));
                model.setPrice(object.optString("price"));
                model.setProduct_name(object.optString("product_name"));
                model.setProduct_image(object.optString("product_image"));
                model.setUnit(object.optString("unit"));

                productListDataModels.add(model);

            }
            return productListDataModels;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
