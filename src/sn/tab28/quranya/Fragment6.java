package sn.tab28.quranya;

import java.lang.reflect.Field;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;

public class Fragment6 extends SherlockFragment {
	// Declare Variable
	private FragmentTabHost mTabHost;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Create FragmentTabHost
		mTabHost = new FragmentTabHost(getSherlockActivity());
		// Locate fragment1.xml to create FragmentTabHost
		mTabHost.setup(getSherlockActivity(), getChildFragmentManager(), R.layout.fragment4);
		// Create Tab 1
		mTabHost.addTab(mTabHost.newTabSpec("tab6").setIndicator(getActivity().getResources().getString(R.string.jukky6)), FragmentTab6.class, null);
		
		return mTabHost;
	}
	
	// Detach FragmentTabHost
	@Override
	public void onDetach() {
		super.onDetach();

		try {
			Field childFragmentManager = Fragment.class
					.getDeclaredField("mChildFragmentManager");
			childFragmentManager.setAccessible(true);
			childFragmentManager.set(this, null);

		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	// Remove FragmentTabHost 
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		mTabHost = null;
	}

}
