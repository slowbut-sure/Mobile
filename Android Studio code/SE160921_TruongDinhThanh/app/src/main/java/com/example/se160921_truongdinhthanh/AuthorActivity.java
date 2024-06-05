package com.example.se160921_truongdinhthanh;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AuthorActivity extends AppCompatActivity {
    ListView lvAuthor;
    ArrayAdapter adapterAuthor;
    List<Author> listAuthor = new ArrayList<>();
    List<Book> listBooks = new ArrayList<>();
    Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tacgia);
        lvAuthor = findViewById(R.id.lvAuthor);
        buttonAdd = findViewById(R.id.buttonAddAuthor);
        listAuthor = AuthorDAO.getAllCategories(AuthorActivity.this);
        if (listAuthor.size() == 0) {
            Toast.makeText(AuthorActivity.this, "Emty", Toast.LENGTH_SHORT).show();
        }
        listBooks = BookDAO.getAll(AuthorActivity.this);
        adapterAuthor = new ArrayAdapter(AuthorActivity.this, android.R.layout.simple_list_item_1, listAuthor);
        lvAuthor.setAdapter(adapterAuthor);

//        lvAuthor.setOnItemClickListener((parent, view, position, id) -> {
//            showUpdateAuthorDialog(position);
//        });

        buttonAdd.setOnClickListener(v -> {
            showAddProductDialog();
        });

    }

    private void showAddProductDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(AuthorActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.add_tacgia, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();

        EditText edtname  = view.findViewById(R.id.edtAddAName);
        EditText edtAdd  = view.findViewById(R.id.edtAddAAdress);
        EditText edtPhone  = view.findViewById(R.id.edtAddAPhone);
        Button buttonSaveProduct = view.findViewById(R.id.btnAddAuthor);

        buttonSaveProduct.setOnClickListener(v -> {

            String productName = edtname.getText().toString();
            String date = edtAdd.getText().toString();
            String type = edtPhone.getText().toString();
            if (AuthorDAO.insert(AuthorActivity.this, productName, date, type)) {
                Toast.makeText(AuthorActivity.this, "Thêm tác giả thành công", Toast.LENGTH_SHORT).show();
                listAuthor.clear();
                listAuthor.addAll(AuthorDAO.getAllCategories(AuthorActivity.this));
                adapterAuthor.notifyDataSetChanged();
                dialog.dismiss();
            } else {
                Toast.makeText(AuthorActivity.this, "Thêm tác giả thất bại", Toast.LENGTH_SHORT).show();
            }
//            }
        });
    }
//    private void showUpdateAuthorDialog(int position) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(AuthorActivity.this);
//        LayoutInflater inflater = getLayoutInflater();
//        View view = inflater.inflate(R.layout.update_tacgia, null);
//        builder.setView(view);
//        Dialog dialog = builder.create();
//        dialog.show();
//
//        List<Integer> cateIDList = new ArrayList<>();
//        for (Author c : listAuthor) {
//            cateIDList.add(c.getAuthorId());
//        }
//
//        EditText edtName = view.findViewById(R.id.edtUpdateName);
//        EditText date  = view.findViewById(R.id.edtUpdateAddress);
//        EditText type  = view.findViewById(R.id.edtUpdatePhone);
//
//        Button buttonUpdateProduct = view.findViewById(R.id.btnUpdatePro);
//        Button buttonDeleteProduct = view.findViewById(R.id.buttonDeleteInUpdate);
//
//        Author product = listAuthor.get(position);
//        edtName.setText(product.getName());
//        date.setText(product.getAddress());
//        type.setText(product.getPhoneNum());
//
////        buttonUpdateProduct.setOnClickListener(v -> {
////            if (!cateIDList.contains(Integer.parseInt(authorId.getText().toString()))) {
////                Toast.makeText(AuthorActivity.this, "ID tác giả không tồn tại", Toast.LENGTH_SHORT).show();
////            } else {
////                product.setName(edtName.getText().toString());
////                product.setAddress(date.getText().toString());
////                product.setPhoneNum(type.getText().toString());
////                if (AuthorDAO.update(AuthorActivity.this, product)) {
////                    Toast.makeText(AuthorActivity.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
////                    listAuthor.clear();
////                    listAuthor.addAll(AuthorDAO.getAllCategories(AuthorActivity.this));
////                    adapterAuthor.notifyDataSetChanged();
////                    dialog.dismiss();
////                } else {
////                    Toast.makeText(AuthorActivity.this, "Sửa thất bại", Toast.LENGTH_SHORT).show();
////                }
////            }
////        });
//
//        buttonDeleteProduct.setOnClickListener(v -> {
//            if (BookDAO.delete(AuthorActivity.this, product.getAuthorId())) {
//                Toast.makeText(AuthorActivity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
//                listAuthor.clear();
//                listAuthor.addAll(AuthorDAO.getAllCategories(AuthorActivity.this));
//                adapterAuthor.notifyDataSetChanged();
//                dialog.dismiss();
//            } else {
//                Toast.makeText(AuthorActivity.this, "Xóa thất bại", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}
