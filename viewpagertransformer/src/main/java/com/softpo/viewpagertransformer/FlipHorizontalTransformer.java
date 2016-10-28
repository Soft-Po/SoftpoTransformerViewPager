package com.softpo.viewpagertransformer;

import android.view.View;

/**
 * 翻页动画
 */
public class FlipHorizontalTransformer extends ABaseTransformer {

	@Override
	protected void onTransform(View view, float position) {
		final float rotation = 180f * position;

		//设置透明度翻过90度时，隐藏
		view.setAlpha(rotation > 90f || rotation < -90f ? 0 : 1);
		view.setPivotX(view.getWidth() * 0.5f);
		view.setPivotY(view.getHeight() * 0.5f);
		view.setRotationY(rotation);
	}

}
