package com.android.jjnunogarcia.smartsearch.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

/**
 * User: jesus
 * Date: 06/03/15
 *
 * @author jjnunogarcia@gmail.com
 */
public class CustomAutoCompleteTextView extends AutoCompleteTextView {
  public CustomAutoCompleteTextView(Context context) {
    super(context);
  }

  public CustomAutoCompleteTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public CustomAutoCompleteTextView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override
  protected void replaceText(CharSequence text) {} // Avoid replace text box when selection tapped
}
