/**
 * @author         zchangyu
 * @Date           2018年4月23日 下午1:20:50
 * @Description    TODO（一句话描述）
 */
package com.hospital.regsystem.utils;

import javax.servlet.http.HttpServletRequest;

public class IPUtils {
	public static String getIp(HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        String forwarded = request.getHeader("X-Forwarded-For");
        String realIp = request.getHeader("X-Real-IP");

        String ip = null;
        if (realIp == null) {
            if (forwarded == null) {
                ip = remoteAddr;
            } else {
                ip = remoteAddr + "/" + forwarded;
            }
        } else {
            if (realIp.equals(forwarded)) {
                ip = realIp;
            } else {
                ip = realIp + "/" + forwarded.replaceAll(", " + realIp, "");
            }
        }
        return ip;
    }
}
