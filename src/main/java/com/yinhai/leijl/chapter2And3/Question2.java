package com.yinhai.leijl.chapter2And3;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;

public class Question2 {



    public static final ThreadLocal<DateFormatter> datteFormatter = ThreadLocal.withInitial(() -> new DateFormatter(
            new SimpleDateFormat("dd-MMM-yyyy")));
}
