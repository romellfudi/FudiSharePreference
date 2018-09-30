package com.romellfudi.sharepreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.romellfudi.sharepreference.resources.ObjectBean;
import com.romellfudi.sharepreference.resources.ObjectDetailBean;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.doAnswer;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @version 1.0
 * @autor Romell Domínguez
 * @date 9/30/18
 */
@RunWith(PowerMockRunner.class)
public class JsonUtilTest {

    @Mock
    Context context;

    @Mock
    SharedPreferences sharedPref;

    @Mock
    SharedPreferences.Editor editor;

    AtomicReference storeValue = new AtomicReference();

    @Captor
    ArgumentCaptor<String> keyCaptor, JSONvalueCaptor;

    @Before
    public void prepareMocks() {
        when(context.getPackageName()).thenReturn(getClass().getPackage().toString());
        when(context.getSharedPreferences(any(String.class), any(Integer.class)))
                .thenReturn(sharedPref);
        when(sharedPref.edit()).thenReturn(editor);
        SharePreferenced.init(context);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                storeValue.set(invocation.getArguments()[0]);
                if (storeValue.get().equals(keyCaptor.getValue()))
                    return JSONvalueCaptor.getValue();
                else return null;
            }
        }).when(sharedPref).getString(any(String.class), eq(""));
    }

    @Test
    public void testSimpleObjectToJson() throws Exception {
        ObjectDetailBean objectDetailBean = new ObjectDetailBean("234");
        objectDetailBean.setName("fudi");
        ArrayList<String> data = new ArrayList<>();
        data.add("hello");
        data.add("wait");
        data.add("bye");
        objectDetailBean.setDetails(data);
        SessionObj.setObjectDetailBeanCurrent(objectDetailBean);
        verify(editor).putString(keyCaptor.capture(), JSONvalueCaptor.capture());

        ObjectDetailBean storedValue = SessionObj.getObjectDetailBeanCurrent();
        assertThat(storedValue,is(notNullValue()));
        assertThat(storedValue,not(equalTo(objectDetailBean)));
        assertThat(storedValue.getName(),is(equalTo(objectDetailBean.getName())));
        assertThat(storedValue.getDetails(),is(equalTo(objectDetailBean.getDetails())));
        assertThat(storedValue.getId(),not(equalTo(objectDetailBean.getId())));

    }

    @Test
    public void testComplexObjectToJson() throws Exception {
        ArrayList<ObjectDetailBean> detailBeans = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ArrayList<String> info = new ArrayList<String>();
            info.add("aa");
            info.add("bbbb");
            info.add("c");
            ObjectDetailBean detailBean = new ObjectDetailBean(info);
            detailBean.setName("id-"+i);

            SessionObj.setObjectDetailBeanCurrent(detailBean);
            verify(editor,times(i+1))
                    .putString(keyCaptor.capture(), JSONvalueCaptor.capture());
            ObjectDetailBean storedValue = SessionObj.getObjectDetailBeanCurrent();

            assertThat(storedValue,is(notNullValue()));
            assertThat(storedValue,not(equalTo(detailBean)));
            assertThat(storedValue.getName(),is(equalTo(detailBean.getName())));
            assertThat(storedValue.getDetails(),is(equalTo(detailBean.getDetails())));

            detailBeans.add(storedValue);
        }
        ObjectBean objectBeanMain = new ObjectBean("Main");
        objectBeanMain.setObjectDetailBeans(detailBeans);

        SessionObj.currentObject(objectBeanMain);
        verify(editor,times(detailBeans.size()+1))
                .putString(keyCaptor.capture(), JSONvalueCaptor.capture());
        ObjectBean storedObjectBeanMain = SessionObj.currentObject();

        assertThat(storedObjectBeanMain,is(notNullValue()));
        for (int i =0; i<storedObjectBeanMain.getObjectDetailBeans().size();i++) {
            ObjectDetailBean storedValue = storedObjectBeanMain.getObjectDetailBeans().get(i);
            ObjectDetailBean detailBean = detailBeans.get(i);
            assertThat(storedValue,is(notNullValue()));
            assertThat(storedValue,not(equalTo(detailBean)));
            assertThat(storedValue.getName(),is(equalTo(detailBean.getName())));
            assertThat(storedValue.getDetails(),is(equalTo(detailBean.getDetails())));
        }
        assertThat(storedObjectBeanMain.getData(),is(equalTo(objectBeanMain.getData())));
    }

}