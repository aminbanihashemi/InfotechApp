package console.infotech.myapplication.customView;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

public class MyButtonView extends Button {
    public MyButtonView(Context context) {
        super(context);
        Typeface irSans = Typeface.createFromAsset(context.getAssets(),"irsans_p30download.com.ttf");
        this.setTypeface(irSans);
    }

    public MyButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface irSans = Typeface.createFromAsset(context.getAssets(),"irsans_p30download.com.ttf");
        this.setTypeface(irSans);
    }
}
