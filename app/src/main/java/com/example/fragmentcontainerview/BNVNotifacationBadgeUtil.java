package com.example.fragmentcontainerview;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * yy
 * 2022/1/12
 */
public class BNVNotifacationBadgeUtil {
    /**
     * 添加消息徽章
     *
     * @param itemIndex 表示添加到第几个ItemView
     * @param desc      每个徽章上的内容是啥
     */
    public static void addNotificationBadge(BottomNavigationView mBNV, int itemIndex, String desc) {
        BottomNavigationItemView mCurrentItemView = getBottomNavigationItemView(mBNV, itemIndex);
        LayoutInflater.from(mBNV.getContext()).inflate(R.layout.notifications_badge, mCurrentItemView, true);
        TextView mBadge = (TextView) mCurrentItemView.findViewById(R.id.notifications_badge);
        if (mBadge != null) {
            mBadge.setText(desc);
        }
    }
    /**
     * 移除消息徽章
     *
     * @param itemIndex
     */
    public static void removeNotificationBadge(BottomNavigationView mBNV, int itemIndex) {
        BottomNavigationItemView mCurrentItemView = getBottomNavigationItemView(mBNV, itemIndex);
        TextView mBadge = (TextView) mCurrentItemView.findViewById(R.id.notifications_badge);
        if (mBadge != null) {
            ((ViewGroup) mBadge.getParent()).removeView(mBadge);
        }
    }
    /**
     * 修改消息徽章上面的内容
     *
     * @param itemIndex
     * @param desc
     */
    public static void modifyNotificationBadgeContent(BottomNavigationView mBNV, int itemIndex, String desc) {
        BottomNavigationItemView mCurrentItemView = getBottomNavigationItemView(mBNV, itemIndex);
        TextView mBadge = (TextView) mCurrentItemView.findViewById(R.id.notifications_badge);
        if (mBadge != null) {
            mBadge.setText(desc);
        }
    }
    /**
     * 判断当前索引对应的ItemView中是否有徽章
     *
     * @param mBNV
     * @param itemIndex
     */
    public static Boolean judgeBadgeExist(BottomNavigationView mBNV, int itemIndex) {
        BottomNavigationItemView mCurrentItemView = getBottomNavigationItemView(mBNV, itemIndex);
        TextView mBadge = (TextView) mCurrentItemView.findViewById(R.id.notifications_badge);
        if (mBadge == null) {
            return false;
        } else {
            return true;
        }
    }
    /**
     * 获取当前索引对应的ItemView对象
     *
     * @param mBNV
     * @param itemIndex
     * @return
     */
    private static BottomNavigationItemView getBottomNavigationItemView(BottomNavigationView mBNV, int itemIndex) {
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) mBNV.getChildAt(0);
        return (BottomNavigationItemView) bottomNavigationMenuView.getChildAt(itemIndex);
    }
}
