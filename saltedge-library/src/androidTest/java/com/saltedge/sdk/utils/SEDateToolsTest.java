/*
Copyright © 2019 Salt Edge. https://saltedge.com

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/
package com.saltedge.sdk.utils;

import android.test.suitebuilder.annotation.SmallTest;

import junit.framework.TestCase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SEDateToolsTest extends TestCase {

    @SmallTest
    public void testParseStringToDate() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
        Date date = sdf.parse("2015-01-23T15:05:13Z");
        assertEquals(date, SEDateTools.parseStringToDate("2015-01-23T15:05:13Z"));
    }

    @SmallTest
    public void testParseShortStringToDate() throws Exception {
        assertThat(SEDateTools.parseShortStringToDate("2015-01-23").toGMTString(),
                equalTo("23 Jan 2015 00:00:00 GMT"));
    }

    @SmallTest
    public void testParseDateToShortString() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
        Date date = sdf.parse("2015-01-23T15:05:13Z");
        assertEquals("2015-01-23", SEDateTools.parseDateToShortString(date));
    }

    @SmallTest
    public void testConvertMaxAgeToExpireAt() throws Exception {
        assertEquals(System.currentTimeMillis() + 1000, SEDateTools.convertMaxAgeToExpireAt(1));
    }
}
