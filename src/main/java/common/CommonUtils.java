package common;

/**
 * Created by hd on 2017/9/13.
 */



        import android.app.Activity;
        import android.content.ComponentName;
        import android.content.Context;
        import android.content.Intent;
        import android.content.pm.PackageInfo;
        import android.content.pm.PackageManager;
        import android.content.pm.ResolveInfo;
        import android.net.ConnectivityManager;
        import android.net.NetworkInfo;
        import android.net.Uri;
        import android.net.wifi.WifiInfo;
        import android.net.wifi.WifiManager;
        import android.os.Build;
        import android.support.v4.content.FileProvider;
        import android.text.TextUtils;

        import java.io.File;
        import java.net.Inet4Address;
        import java.net.InetAddress;
        import java.net.NetworkInterface;
        import java.net.SocketException;
        import java.text.SimpleDateFormat;
        import java.util.Date;
        import java.util.Enumeration;
        import java.util.List;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;


/**
 * Created by Administrator on 2017/4/20.
 */

public class CommonUtils {
    /**
     * 是否是手机号
     *
     * @param mobile
     * @return
     */
    public static boolean checkMobile(String mobile) {
        Pattern p = Pattern.compile("^[1]([3|5|6|7|8][0-9]{1}|59|58|88|89)[0-9]{8}$");
        Matcher m = p.matcher(mobile);
        return m.matches();
    }



    /**
     * 获取本地app的版本号
     *
     * @return
     */
    public static int getVersionCode(Context mActivity) {
        PackageManager packageManager = mActivity.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(mActivity.getPackageName(), 0);// 获取包的信息
            int versionCode = packageInfo.versionCode;
            return versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            // 没有找到包名的时候会走此异常
            e.printStackTrace();
        }

        return -1;
    }

    /**
     * 获取本地app的版本名
     *
     * @return
     */
    public static String getVersionName(Activity mActivity) {
        PackageManager packageManager = mActivity.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(mActivity.getPackageName(), 0);// 获取包的信息
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            // 没有找到包名的时候会走此异常
            e.printStackTrace();
        }

        return "";
    }

    //安装下载后的apk文件
    public static void instanll(final Context cxt, final File file) {
        if (file != null && file.exists()) {
//                    Intent intent = new Intent(Intent.ACTION_VIEW);
//
//                    intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
//                    intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
//                    cxt.startActivity(intent);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                Uri contentUri = FileProvider.getUriForFile(cxt, cxt.getPackageName() + ".provider", file);
                intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
            } else {
                intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            }
            if (cxt.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
                cxt.startActivity(intent);
            }
        } else {

        }


    }

    /**
     * 判断 用户是否安装微信客户端
     */
    public static boolean isWeixinAvilible(Context context) {
        final PackageManager packageManager = context.getPackageManager();// 获取packagemanager
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                if (pn.equals("com.tencent.mm")) {
                    return true;
                }
            }
        }
        return false;
    }



    /**
     * 隐藏号
     *
     * @param id
     * @return
     */
    public static String getHiddenID(String id) {
        if (TextUtils.isEmpty(id)) return "";
        if (id.length() < 4) return id;

        return "后四位：" + id.substring(id.length() - 4);
    }

    public static String getHiddenName(String name) {
        if (TextUtils.isEmpty(name)) return "";
        String result = "";
        String end = name.substring(name.length() - 1);
        for (int i = 0; i < name.length() - 1; i++) {
            result += "*";
        }
        return result + end;
    }

    public static String getHiddenID2(String id) {
        if (TextUtils.isEmpty(id)) return "";
        String result = "";
        String end = id.substring(id.length() - 4);
        for (int i = 0; i < id.length() - 4; i++) {
            result += "*";
            if ((i + 1) % 4 == 0) {
                result += " ";
            }
        }
        return result + " " + end;
    }

//    获取当前IP

    public static String getIPAddress(Context context) {
        NetworkInfo info = ((ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            if (info.getType() == ConnectivityManager.TYPE_MOBILE) {//当前使用2G/3G/4G网络
                try {
                    //Enumeration<NetworkInterface> en=NetworkInterface.getNetworkInterfaces();
                    for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                        NetworkInterface intf = en.nextElement();
                        for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                            InetAddress inetAddress = enumIpAddr.nextElement();
                            if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                                return inetAddress.getHostAddress();
                            }
                        }
                    }
                } catch (SocketException e) {
                    e.printStackTrace();
                }

            } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {//当前使用无线网络
                WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                String ipAddress = intIP2StringIP(wifiInfo.getIpAddress());//得到IPV4地址
                return ipAddress;
            }
        } else {
            //当前无网络连接,请在设置中打开网络
        }
        return null;
    }

    private static String intIP2StringIP(int ip) {

        return (ip & 0xFF) + "." +
                ((ip >> 8) & 0xFF) + "." +
                ((ip >> 16) & 0xFF) + "." +
                (ip >> 24 & 0xFF);
    }

    //    获取当前时间
    public static String time() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        return time;
    }

    public static Intent getExplicitIntent(Context context, Intent implicitIntent) {
        // Retrieve all services that can match the given intent
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> resolveInfo = pm.queryIntentServices(implicitIntent, 0);
        // Make sure only one match was found
        if (resolveInfo == null || resolveInfo.size() != 1) {
            return null;
        }
        // Get component info and create ComponentName
        ResolveInfo serviceInfo = resolveInfo.get(0);
        String packageName = serviceInfo.serviceInfo.packageName;
        String className = serviceInfo.serviceInfo.name;
        ComponentName component = new ComponentName(packageName, className);
        // Create a new intent. Use the old one for extras and such reuse
        Intent explicitIntent = new Intent(implicitIntent);
        // Set the component to be explicit
        explicitIntent.setComponent(component);
        return explicitIntent;
    }
}

