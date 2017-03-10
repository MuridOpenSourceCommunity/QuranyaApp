package sn.tab28.quranya;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;

public class FragmentTab1 extends SherlockFragment {
	private String[] arab = null;
	private String[] fran = null;
	private String[] trans = null;
	private ListView listView;
	private List<RowItem> rowItems;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragmenttab1, container,
				false);
		arab = getResources().getStringArray(R.array.Quranya_1);
		fran = getResources().getStringArray(R.array.Quranya_1f);
		trans = getResources().getStringArray(R.array.Quranya_1t);
		rowItems = new ArrayList<RowItem>();
		RowItem item = null;
		for (int i = 0; i < arab.length; i++) {
			item = new RowItem(arab[i],fran[i],trans[i]);
			rowItems.add(item);
		}

		listView = (ListView) rootView.findViewById(R.id.listf1);
		CustomListViewAdapter adapter = new CustomListViewAdapter(
				getActivity(), R.layout.list_item, rowItems);
		listView.setAdapter(adapter);

		
		return rootView;
	}

}
