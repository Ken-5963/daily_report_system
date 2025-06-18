package test;

import java.util.List;

import actions.views.EmployeeView;
import services.EmployeeService;

public class TestEmployeeService {

    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();

        //service.create() のテスト
        //従業員を1件登録する（一人目）
        String code1 = "X001";  // "ここに従業員のコードを入れる";
        String pass1 = "password";//"ここに従業員のパスワードを入れる";
        EmployeeView ev = new EmployeeView(null, code1, "tanaka", pass1, 0,  null,  null, 0);
        List<String> errors = service.create(ev , "6Ab3mtmG");
        
        if (errors.size() > 0) {
            System.out.println("■■1件目の従業員の登録でエラーが発生しました。");
        } else {
            System.out.println("■■1件目の従業員の登録が成功しました。");      
            System.out.println("■■--service.create()のテストに成功--");
        }
        
        //service.create() のテスト
        //従業員を1件登録する（二人目）
        String code2 =  "X002";//"ここに従業員のコードを入れる";
        String pass2 = "password";//"ここに従業員のパスワードを入れる";
        EmployeeView ev2 = new EmployeeView(null, code2, "tanaka", pass2, 0,  null,  null, 0);
        List<String> errors2 = service.create(ev2 , "6Ab3mtmG");
        
        if (errors2.size() > 0) {
            System.out.println("■■2件目の従業員の登録でエラーが発生しました。");
        }else {
            System.out.println("■■2件目の従業員の登録が成功しました。");   
            System.out.println("■■--service.create()のテストに成功--");
        }
        //service.findOne(id)のテスト
        //1件目の従業員を取得する（id指定）
        EmployeeView view1 = service.findOne(1);
        System.out.println("■■1件目の従業員のオブジェクトは・・・ " + view1);
        System.out.println("■■--service.findOne(id) のテストに成功--");
        
      //service.findOne(code)のテスト
        //2件目の従業員を取得する（code指定）     
        EmployeeView view2 = service.findOne(code2, pass2, "6Ab3mtmG");
        System.out.println("■■2件目の従業員のオブジェクトは・・・ " + view2);
        System.out.println("■■--service.findOne(code)のテストに成功--");
        
        //service.getPerPage(1)とservice.countAll()のテスト
        //全従業員を取得する
        long count = service.countAll();
        System.out.println("■■全従業員は" + count + "人です");
        
        List<EmployeeView> emps = service.getPerPage(1);
        for(EmployeeView emp: emps) {
            System.out.println(emp.getName());
        }
        //service.countByCode(code1)のテスト
        //1件目の従業員と同じcodeの件数をカウントする
        long count2 = service.countByCode(code1);
        System.out.println("■■" + code1 + "を持つ従業員レコ-ドは " + count2 + "件あります");
        System.out.println("■■--service.countByCode(code)のテストに成功--");

        //1件目の従業員の名前を変更する
        ev.setName("Suzuki");
        List<String> errors3 = service.update(ev, "6Ab3mtmG");
        if (errors3.size() > 0) {
            System.out.println("■■1件目の従業員の更新でエラーが発生しました。");
        }else {
            System.out.println("■■1件目の従業員の更新が成功しました。");      
            System.out.println("■■--service.update()のテストに成功--");
        }
        
        //service.destroy()のテスト、テーブルを確認して削除フラグが1になっていたら成功
        //2件目の従業員を削除する       
        service.destroy(ev2.getId());
        
        //service.validateLogin()のテスト
        //1件目の従業員のログイン確認をする
        Boolean flag =  service.validateLogin(ev.getCode(), ev.getPassword(), "6Ab3mtmG");
        if(flag) {
            System.out.println("■■ログイン認証に成功しました");
        }else {
            System.out.println("■■ログイン認証に失敗しました");
        }
        
        service.close();
    }

}