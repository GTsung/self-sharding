package com.self.sharding.second.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtil {

    public static final String COMMON_SECOND_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String COMMON_DATE_PATTERN = "yyyy-MM-dd";
    public static final String COMMON_DAY_PATTERN = "yyyy/MM/dd";

    public static final DateTimeFormatter COMMON_SECOND_FORMATTER = DateTimeFormatter.ofPattern(COMMON_SECOND_PATTERN);
    public static final DateTimeFormatter COMMON_DATE_FORMATTER = DateTimeFormatter.ofPattern(COMMON_DATE_PATTERN);

    public static Date str2Date(String date) {
        return str2Date(date, COMMON_SECOND_PATTERN);
    }

    public static Date str2Date(String date, String pattern) {
        if (StringUtils.isBlank(date) || StringUtils.isBlank(pattern)) {
            return null;
        }
        try {
            SimpleDateFormat dft = new SimpleDateFormat(pattern);
            return dft.parse(date);
        } catch (Exception e) {
            log.error("[{}]-[{}]-日期格式转换错误", date, pattern);
        }
        return null;
    }

    public static String date2Str(Date date) {
        return date2Str(date, COMMON_SECOND_FORMATTER);
    }

    public static String date2Str(Date date, DateTimeFormatter pattern) {
        if (date == null) {
            return null;
        }
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime dt = LocalDateTime.ofInstant(date.toInstant(), zoneId);
        return dt.format(pattern);
    }

    public static LocalDateTime str2LocalDateTime(String date) {
        return LocalDateTime.parse(date, COMMON_SECOND_FORMATTER);
    }

    public static LocalDateTime str2LocalDateTime(String date, DateTimeFormatter pattern) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        return LocalDateTime.parse(date, pattern);
    }

    public static String localDateTime2Str(LocalDateTime date) {
        return date.format(COMMON_SECOND_FORMATTER);
    }

    public static String localDateTime2Str(LocalDateTime date, DateTimeFormatter formatter) {
        if (date == null) {
            return null;
        }
        return date.format(formatter);
    }

    public static LocalDateTime date2LocalDateTime(Date date) {
        if (date == null) {
            return null;
        }
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(date.toInstant(), zoneId);
    }

    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDateTime plusDays(LocalDateTime localDateTime, int days) {
        if (localDateTime == null) {
            return null;
        }
        return localDateTime.plusDays(days);
    }

    public static Date plusDays(Date date, int days) {
        if (date == null) {
            return null;
        }
        return localDateTime2Date(date2LocalDateTime(date).plusDays(days));
    }

    public static Date plusMinutes(Date date, int minutes) {
        if (date == null) {
            return null;
        }
        return localDateTime2Date(date2LocalDateTime(date).plusMinutes(minutes));
    }

    public static Date plusHours(Date date, int hours) {
        if (date == null) {
            return null;
        }
        return localDateTime2Date(date2LocalDateTime(date).plusHours(hours));
    }

    public static Date plusMonth(Date date, int months) {
        if (date == null) {
            return null;
        }
        return localDateTime2Date(date2LocalDateTime(date).plusMonths(months));
    }
}