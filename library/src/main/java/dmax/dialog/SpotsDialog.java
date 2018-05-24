package dmax.dialog;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Maxim Dybarsky | maxim.dybarskyy@gmail.com
 * on 13.01.15 at 14:22
 */
public class SpotsDialog extends AlertDialog {

    public static class Builder {

        private Context context;
        private String message;
        private int messageId;
        private int themeId;
        private boolean cancelable = true; // default dialog behaviour
        private OnCancelListener cancelListener;
        private int Duration = 1500;
        private int Delay = 150;

        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setMessage(int messageId) {
            this.messageId = messageId;
            return this;
        }

        public Builder setDuration(int Duration) {
            this.Duration = Duration;
            return this;
        }

        public Builder setDelay(int Delay) {
            this.Delay = Delay;
            return this;
        }

        public Builder setTheme(int themeId) {
            this.themeId = themeId;
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public Builder setCancelListener(OnCancelListener cancelListener) {
            this.cancelListener = cancelListener;
            return this;
        }

        public AlertDialog build() {
            return new SpotsDialog(
                    context,
                    messageId != 0 ? context.getString(messageId) : message,
                    themeId != 0 ? themeId : R.style.SpotsDialogDefault,
                    cancelable,
                    cancelListener,
                    Duration,
                    Delay
            );
        }
    }

    private int DELAY;
    private int DURATION;

    private int size;
    private AnimatedView[] spots;
    private AnimatorPlayer animator;
    private CharSequence message;


    private SpotsDialog(Context context, String message, int theme, boolean cancelable, OnCancelListener cancelListener, int Duration, int Delay) {
        super(context, theme);
        this.message = message;
        DURATION = Duration;
        DELAY = Delay;
        setCancelable(cancelable);
        if (cancelListener != null) setOnCancelListener(cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dmax_spots_dialog);
        setCanceledOnTouchOutside(false);

        initMessage();
        initProgress();
    }

    @Override
    protected void onStart() {
        super.onStart();

        for (AnimatedView view : spots) view.setVisibility(View.VISIBLE);

        animator = new AnimatorPlayer(createAnimations());
        animator.play();
    }

    @Override
    protected void onStop() {
        super.onStop();

        animator.stop();
    }

    @Override
    public void setMessage(CharSequence message) {
        this.message = message;
        if (isShowing()) initMessage();
    }

    //~

    private void initMessage() {
        if (message != null && message.length() > 0) {
            ((TextView) findViewById(R.id.dmax_spots_title)).setText(message);
        }
    }

    private void initProgress() {
        ProgressLayout progress = (ProgressLayout) findViewById(R.id.dmax_spots_progress);
        size = progress.getSpotsCount();

        spots = new AnimatedView[size];
        int size = getContext().getResources().getDimensionPixelSize(R.dimen.spot_size);
        int progressWidth = getContext().getResources().getDimensionPixelSize(R.dimen.progress_width);
        for (int i = 0; i < spots.length; i++) {
            AnimatedView v = new AnimatedView(getContext());
            v.setBackgroundResource(R.drawable.dmax_spots_spot);
            v.setTarget(progressWidth);
            v.setXFactor(-1f);
            v.setVisibility(View.INVISIBLE);
            progress.addView(v, size, size);
            spots[i] = v;
        }
    }

    private Animator[] createAnimations() {
        Animator[] animators = new Animator[size];
        for (int i = 0; i < spots.length; i++) {
            Animator move = ObjectAnimator.ofFloat(spots[i], "xFactor", 0, 1);
            move.setDuration(DURATION);
            move.setInterpolator(new HesitateInterpolator());
            move.setStartDelay(DELAY * i);
            animators[i] = move;
        }
        return animators;
    }
}
