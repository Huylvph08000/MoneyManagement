package com.example.moneymanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.menu_quanlyloaichi:
                fragment = new DanhSachKhoanChiFragment();
                this.setTitle("Danh sách loại chi");
                fragmentTransaction.replace(R.id.frameContent, fragment);
                fragmentTransaction.commit();
                return true;
            case R.id.menun_themloaichi:
                fragment = new ThemLoaiChiFragment();
                this.setTitle("Thêm loại chi");
                fragmentTransaction.replace(R.id.frameContent, fragment, "themloaichi");
                fragmentTransaction.commit();
                return true;
            case R.id.menu_thongKe:
                fragment = new ThongKeFragment();
                this.setTitle("Danh sách thống kê");
                fragmentTransaction.replace(R.id.frameContent, fragment);
                fragmentTransaction.commit();
                return true;
            case R.id.menu_thoat:
                System.exit(0);
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }

    }
}
