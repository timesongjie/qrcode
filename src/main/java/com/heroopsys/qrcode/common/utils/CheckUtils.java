package com.heroopsys.qrcode.common.utils;

import javax.servlet.http.HttpServletRequest;

import com.bbkmobile.iqoo.common.constants.VivoSignConstants;
import com.bbkmobile.iqoo.common.logging.Lg;
import com.bbkmobile.iqoo.common.util.VivoSign;

public class CheckUtils {
    public static final Boolean SIGN_CHECK = false;

    public static Boolean checkSign(HttpServletRequest request) {
        if (SIGN_CHECK) {
            Boolean re = VivoSign.checkSign(VivoSignConstants.VIVO_SIGN_KEY, request);
            if (!re) {
                Lg.error(CheckUtils.class, "sign err!");
            }
            return re;
        }
        return true;
    }
}
