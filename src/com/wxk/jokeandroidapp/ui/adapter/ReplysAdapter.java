package com.wxk.jokeandroidapp.ui.adapter;

import com.wxk.jokeandroidapp.R;
import com.wxk.jokeandroidapp.bean.ReplyBean;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public abstract class ReplysAdapter extends UtilAdapter<ReplyBean> {

	private int jokeId;

	public ReplysAdapter(int jokeId, ListView listView, View header,
			View footer, int itemLayout) {
		super(listView, header, footer, itemLayout);
		this.jokeId = jokeId;
	}

	public int getJokeId() {
		return jokeId;
	}

	@Override
	protected Object initViewHolder(ReplyBean bean, View view, Object obj,
			int position) {
		ViewHolder viewHolder;
		if (obj == null)
			viewHolder = new ViewHolder();
		else
			viewHolder = (ViewHolder) obj;

		viewHolder.txtvContext = (TextView) view
				.findViewById(R.id.txtv_reply_content);
		if (viewHolder.txtvContext != null)
			viewHolder.txtvContext.setText(bean.getContent());
		viewHolder.txtvDate = (TextView) view
				.findViewById(R.id.txtv_reply_date);
		if (viewHolder.txtvDate != null)
			viewHolder.txtvDate.setText(bean.getActiveDate());
		viewHolder.txtvFloor = (TextView) view.findViewById(R.id.txtv_floor);
		if (viewHolder.txtvFloor != null)
			viewHolder.txtvFloor.setText("#" + (position + 1));
		return viewHolder;
	}

	private static class ViewHolder {
		public TextView txtvDate;
		public TextView txtvContext;
		public TextView txtvFloor;
	}
}