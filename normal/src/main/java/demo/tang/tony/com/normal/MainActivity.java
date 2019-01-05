package demo.tang.tony.com.normal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private TextView tv_hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_hello = findViewById(R.id.tv_hello);
        test();
    }

    private void test() {
        compositeDisposable.add(Observable.just("hello")
                .subscribeOn(Schedulers.io())
                .map(this::hello)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::consume));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }

    private void consume(String src) {
        tv_hello.setText(src);
    }

    private String hello(String greeting) {
        return greeting + " Tony";
    }
}
