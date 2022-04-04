package com.example.myapp.lab3;

import android.os.AsyncTask;

public class FindUserOperation extends AsyncTask<String, Void, User> {

    UserOperations listener;

    public FindUserOperation(UserOperations listener){
        this.listener = listener;
    }

    @Override
    protected User doInBackground(String... strings) {
        String name = strings[0];
        return MyApplication.getmAppDatabase().userDao().findUserWithName(name);
    }
    @Override
    protected void onPostExecute( User user){
        listener.findUser(user);}
}
