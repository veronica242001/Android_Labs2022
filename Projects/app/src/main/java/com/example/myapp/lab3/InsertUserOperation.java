package com.example.myapp.lab3;

import android.os.AsyncTask;
                                                 //
public class InsertUserOperation extends AsyncTask<User, Void, String> {

    UserOperations listener;

     public InsertUserOperation(UserOperations listener) {
         this.listener = listener;
     }

     @Override
     protected String doInBackground(User... users) {

         try {
             MyApplication.getmAppDatabase().userDao().insertAll(users);
         } catch (Exception e) {
             return "error";
         }
         return "succes";

     }

     //este apelat cand se termina se executat operatiile de acolo
       @Override
       protected void onPostExecute(String result) { listener.insertUsers(result); }


}
