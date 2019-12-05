package com.example.moneymanagement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.moneymanagement.dao.LoaiChiDAO;
import com.example.moneymanagement.model.LoaiChi;

public class ThemLoaiChiFragment extends Fragment {
    private LoaiChiDAO loaiChiDAO;
    public ThemLoaiChiFragment(){};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        loaiChiDAO = new LoaiChiDAO(getActivity());
        View view = inflater.inflate(R.layout.them_loai_chi_fragment, container, false);
        Button btLuu = view.findViewById(R.id.add);
        Button btHuy = view.findViewById(R.id.cancer);
        final EditText edMaLoaiChi = view.findViewById(R.id.txtMaLoaiChi);
        final EditText edTenLoaiChi = view.findViewById(R.id.txtTenLoaiChi);

        btLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maLC = edMaLoaiChi.getText().toString();
                String tenLC = edTenLoaiChi.getText().toString();
                LoaiChi objloaiChi = new LoaiChi(maLC, tenLC);
                boolean isSuccess = loaiChiDAO.insertLoaiChi(objloaiChi);
                if(isSuccess){
                    Toast.makeText(getActivity(),"Chen thanh cong", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getActivity(),"Chen that bai", Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Danh sách loại chi");
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
