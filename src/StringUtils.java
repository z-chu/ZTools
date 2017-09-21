
import android.support.annotation.NonNull;



/**
 * Created by newbiechen on 17-4-22.
 * 对文字操作的工具类
 */

public class StringUtils {
  
    /**
     * 将文本中的半角字符，转换成全角字符
     *
     * @param input
     * @return
     */
    public static String halfToFull(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 32) //半角空格
            {
                c[i] = (char) 12288;
                continue;
            }
            //根据实际情况，过滤不需要转换的符号
            //if (c[i] == 46) //半角点号，不转换
            // continue;

            if (c[i] > 32 && c[i] < 127)    //其他符号都转换为全角
                c[i] = (char) (c[i] + 65248);
        }
        return new String(c);
    }

    //功能：字符串全角转换为半角
    public static String fullToHalf(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) //全角空格
            {
                c[i] = (char) 32;
                continue;
            }

            if (c[i] > 65280 && c[i] < 65375)
                c[i] = (char) (c[i] - 65248);
        }
        return new String(c);
    }

    /**
     * 判断string是否是一个空白字符，即长度为0或全是空格(包括全角和半角)
     *
     * @param str 一个不为null的字符串
     * @return 是否是一个空白字符
     */
    public static boolean isBlank(@NonNull String str) {
        int len = str.length();
        int st = 0;
        if (len > 0) {
            while (st < len) {
                char charAt = str.charAt(st);
                if (charAt == 32 || charAt == 12288) {
                    st++;
                } else {
                    break;
                }

            }
        }
        return st == len;
    }

    /**
     * 去除字符串前后的空格(包括全角和半角)
     *
     * @param str 一个不为null的字符串
     * @return 去掉空格的字符串
     */
    public static String trim(@NonNull String str) {
        int len = str.length();
        int st = 0;
        while (st < len) {
            char charAt = str.charAt(st);
            if (charAt == 32 || charAt == 12288) {
                st++;
            } else {
                break;
            }
        }
        while (st < len) {
            char charAt = str.charAt(len - 1);
            if (charAt == 32 || charAt == 12288) {
                len--;
            } else {
                break;
            }
        }
        return ((st > 0) || (len < str.length())) ? str.substring(st, len) : str;
    }

    /**
     * 去除字符串前后的空格(包括全角和半角),并将前面去掉的空格替换为想要的字符
     *
     * @param str 一个不为null的字符串
     * @return 去掉空格的字符串
     */
    public static String trimBeforeReplace(@NonNull String str,String replacement) {
        int len = str.length();
        int st = 0;
        while (st < len) {
            char charAt = str.charAt(st);
            if (charAt == 32 || charAt == 12288) {
                st++;
            } else {
                break;
            }
        }
        while (st < len) {
            char charAt = str.charAt(len - 1);
            if (charAt == 32 || charAt == 12288) {
                len--;
            } else {
                break;
            }
        }
        return ((st > 0) || (len < str.length())) ? replacement+str.substring(st, len) : str;
    }

}
