//package tvd.pro.quanlysinhvien;
//
//import android.app.Activity;
//import android.app.AlertDialog;
//import android.app.DatePickerDialog;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//
//public class AdapterSinhVien extends BaseAdapter {
//
//    Activity context;
//    ArrayList<SinhVien> list;
//
//    public AdapterSinhVien(Activity context, ArrayList<SinhVien> list) {
//        this.context = context;
//        this.list = list;
//    }
//
//    @Override
//    public int getCount() {
//        return list.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return 0;
//    }
//
//    @Override
//    public View getView(final int i, View view, ViewGroup viewGroup) {
//        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View row = inflater.inflate(R.layout.listview_row,null);
//        ImageView imgAvatar = (ImageView) row.findViewById(R.id.imageAvatar);
//        TextView txtID = (TextView) row.findViewById(R.id.txtID);
//        TextView txtTen = (TextView) row.findViewById(R.id.txtTen);
//        TextView txtLop = (TextView) row.findViewById(R.id.txtLop);
//        Button btnsua = (Button) row.findViewById(R.id.btnsua);
//        Button btnxoa = (Button) row.findViewById(R.id.btnxoa);
//
//        final SinhVien sinhVien = list.get(i);
//        txtID.setText(sinhVien.ID + "");
//        txtTen.setText(sinhVien.Ten);
//        txtLop.setText(sinhVien.Lop);
//
//
//        btnsua.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context , UpdateActivity.class);
//                intent.putExtra("ID",sinhVien.ID);
//                context.startActivity(intent);
//
//            }
//        });
//        btnxoa.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                builder.setIcon(android.R.drawable.ic_delete);
//                builder.setTitle("Xác Nhận Xóa");
//                builder.setMessage("Bạn có chắc chắn muốn xóa sinh viên này không ? ");
//                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        delete(sinhVien.ID);
//                    }
//                });
//                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                });
//                AlertDialog dialog = builder.create();
//                dialog.show();
//            }
//        });
//
////        Bitmap bmAvatar = BitmapFactory.decodeByteArray(sinhVien.Anh,0,sinhVien.Anh.length);
////        imgAvatar.setImageBitmap(bmAvatar);
//
//        return row;
//    }
//
//    private void delete(int idSinhvien) {
//        SQLiteDatabase database = Database.initDatabase(context,"QLSV");
//
//        database.delete("SinhVien","MASV = ?", new String[]{idSinhvien + ""});
//        list.clear();
//        Cursor cursor = database.rawQuery("SELECT * FROM SinhVien", null);
//        while(cursor.moveToNext()){
//            int id = cursor.getInt(0);
//            String ten = cursor.getString(1);
//            String lop = cursor.getString(2);
////            byte[] anh = cursor.getBlob(5);
//
//            list.add(new SinhVien(id,ten,lop,null));
//
//        }
//        notifyDataSetChanged();
//
//
//
//
//    }
//}
