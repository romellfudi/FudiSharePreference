package com.romellfudi.sharepreference

import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.romellfudi.sharepreference.resources.ObjectBean
import com.romellfudi.sharepreference.resources.ObjectDetailBean
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.slot
import io.mockk.verify
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.powermock.core.classloader.annotations.PrepareForTest
import java.util.concurrent.atomic.AtomicReference

/**
 * Created by romelldominguez on 5/15/16.
 */
@PrepareForTest(Uri::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class JsonUtilTest {

    @Mock
    internal val context: Context = mock()

    @Mock
    internal val sharedPref: SharedPreferences = mock()

    @RelaxedMockK
    lateinit var editor: SharedPreferences.Editor

    internal var storeValue = AtomicReference<String>()

    val keyCaptor = slot<String>()
    val JSONvalueCaptor = slot<String>()

    @Before
    fun prepareMocks() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        `when`(context.packageName).thenReturn(javaClass.getPackage()!!.toString())
        `when`(context.getSharedPreferences(any(), any())).thenReturn(sharedPref)
        `when`(sharedPref.edit()).thenReturn(editor)
        SharePreferenced.init(context)
        whenever(sharedPref.getString(any(), eq("")))
                .thenAnswer {
                    storeValue.set(it.arguments[0] as String?)
                    if (storeValue.get().equals(keyCaptor.captured)) JSONvalueCaptor.captured else null
                }
    }

    @Test
    @Throws(Exception::class)
    fun testSimpleObjectToJson() {
        val objectDetailBean = ObjectDetailBean("234")
        objectDetailBean.name = "fudi"
        val data = ArrayList<String>()
        data.add("hello")
        data.add("wait")
        data.add("bye")
        objectDetailBean.details = data
        SessionObj.objectDetailBeanCurrent = objectDetailBean

        verify { editor.putString(capture(keyCaptor), capture(JSONvalueCaptor)) }

        val storedValue = SessionObj.objectDetailBeanCurrent
        assertThat<ObjectDetailBean>(storedValue, `is`(notNullValue<Any>()))
        assertThat(storedValue, not(equalTo(objectDetailBean)))
        assertThat(storedValue!!.name, `is`(equalTo(objectDetailBean.name)))
        assertThat(storedValue!!.details, `is`(equalTo(objectDetailBean.details)))
        assertThat(storedValue!!.idNotHasSetter, `is`(equalTo(objectDetailBean.idNotHasSetter)))

    }

    @Test
    @Throws(Exception::class)
    fun testComplexObjectToJson() {
        val detailBeans = ArrayList<ObjectDetailBean>()
        for (i in 0..4) {
            val info = ArrayList<String>()
            info.add("aa")
            info.add("bbbb")
            info.add("c")
            val detailBean = ObjectDetailBean(info)
            detailBean.name = "id-$i"

            SessionObj.objectDetailBeanCurrent = detailBean
            verify(exactly = i + 1) {
                editor.putString(capture(keyCaptor), capture(JSONvalueCaptor))
            }

            val storedValue = SessionObj.objectDetailBeanCurrent
            assertThat<ObjectDetailBean>(storedValue, `is`(notNullValue<Any>()))
            assertThat(storedValue, not(equalTo(detailBean)))
            assertThat(storedValue!!.name, `is`(equalTo(detailBean.name)))
            assertThat(storedValue!!.details, `is`(equalTo(detailBean.details)))

            detailBeans.add(storedValue)
        }
        val objectBeanMain = ObjectBean("Main")
        objectBeanMain.objectDetailBeans = detailBeans

        SessionObj.currentObject(objectBeanMain)
        verify(exactly = detailBeans.size + 1) {
            editor.putString(capture(keyCaptor), capture(JSONvalueCaptor))
        }
        val storedObjectBeanMain = SessionObj.currentObject()

        assertThat(storedObjectBeanMain, `is`(notNullValue<Any>()))
        for (i in 0 until storedObjectBeanMain!!.objectDetailBeans!!.size) {
            val storedValue = storedObjectBeanMain.objectDetailBeans!![i]
            val detailBean = detailBeans[i]
            assertThat(storedValue, `is`(notNullValue<Any>()))
            assertThat(storedValue, not(equalTo(detailBean)))
            assertThat(storedValue.name, `is`(equalTo(detailBean.name)))
            assertThat(storedValue.details, `is`(equalTo(detailBean.details)))
        }
        assertThat(storedObjectBeanMain.data, `is`(equalTo(objectBeanMain.data)))
    }

}