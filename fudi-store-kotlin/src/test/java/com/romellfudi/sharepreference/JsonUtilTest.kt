/*
 * Copyright (c) 2021. BoostTag E.I.R.L. Romell D.Z.
 * All rights reserved
 * portfolio.romellfudi.com
 */

package com.romellfudi.sharepreference

import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.romellfudi.sharepreference.resources.NonAnnotation
import com.romellfudi.sharepreference.resources.NonDataClass
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

    private var storeValue = AtomicReference<String>()

    private val keyCaptor = slot<String>()
    private val JSONvalueCaptor = slot<String>()

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
                    if (storeValue.get() == keyCaptor.captured) JSONvalueCaptor.captured else null
                }
    }

    @Test
    @Throws(Exception::class)
    fun nonAnnotationTest() {
        val nonAnnotationBean = NonAnnotation("234")
                .apply {
                    name = "fudi"
                    details = arrayListOf("hello", "wait", "bye")
                }
        assertThat(nonAnnotationBean::class.isData, `is`(true))
        assertThat(nonAnnotationBean::class.annotations.find { it is Fudi } as? Fudi,
                `is`(nullValue()))
        nonAnnotationBean.save()
        val storedValue = NonAnnotation()
        storedValue.load()
        assertThat(storedValue == nonAnnotationBean, `is`(false))
    }

    @Test
    @Throws(Exception::class)
    fun nonDataClassTest() {
        val nonDataClass = NonDataClass("234")
                .apply {
                    name = "fudi"
                    details = arrayListOf("hello", "wait", "bye")
                }
        assertThat(nonDataClass::class.isData, `is`(false))
        assertThat(nonDataClass::class.annotations.find { it is Fudi } as? Fudi,
                `is`(notNullValue()))
        nonDataClass.save()
        val storedValue = NonDataClass()
        storedValue.load()
        assertThat(storedValue == nonDataClass, `is`(false))
    }

    @Test
    @Throws(Exception::class)
    fun testSimpleObjectToJson() {
        val objectDetailBean = ObjectDetailBean("234")
                .apply {
                    name = "fudi"
                    details = arrayListOf("hello", "wait", "bye")
                }
        assertThat(objectDetailBean::class.isData, `is`(true))
        assertThat(objectDetailBean::class.annotations.find { it is Fudi } as? Fudi,
                `is`(notNullValue()))
        objectDetailBean.save()
        verify { editor.putString(capture(keyCaptor), capture(JSONvalueCaptor)) }
        val storedValue = ObjectDetailBean()
        storedValue.load()
        assertThat<ObjectDetailBean>(objectDetailBean, `is`(notNullValue()))
        assertThat<ObjectDetailBean>(storedValue, `is`(notNullValue()))
        assertThat(storedValue, equalTo(objectDetailBean))
    }

    @Test
    @Throws(Exception::class)
    fun testComplexObjectToJson() {
        val detailBeans = ArrayList<ObjectDetailBean>()
        (0..4).forEach {
            val detailBean = ObjectDetailBean().apply {
                name = "id-$it"
                details = arrayListOf("aa", "bbbb", "c")
            }
            assertThat(detailBean::class.isData, `is`(true))
            detailBean.save()
            verify(exactly = it + 1) {
                editor.putString(capture(keyCaptor), capture(JSONvalueCaptor))
            }
            val storedValue = ObjectDetailBean()
            storedValue.load()
            assertThat<ObjectDetailBean>(storedValue, `is`(notNullValue()))
            assertThat(storedValue, equalTo(detailBean))
            detailBeans.add(storedValue)
        }
        val objectBeanMain = ObjectBean("Main")
        assertThat(objectBeanMain::class.isData, `is`(true))
        assertThat(objectBeanMain::class.annotations.find { it is Fudi } as? Fudi,
                `is`(notNullValue()))

        objectBeanMain.save()

        verify(exactly = detailBeans.size + 1) {
            editor.putString(capture(keyCaptor), capture(JSONvalueCaptor))
        }
        val storedObjectBeanMain = ObjectBean("Main")
        storedObjectBeanMain.load()

        assertThat(storedObjectBeanMain, `is`(notNullValue()))
        storedObjectBeanMain.objectDetailBeans?.forEachIndexed { index, objectDetailBean ->
            assertThat(objectDetailBean, `is`(notNullValue()))
            assertThat(detailBeans[index], `is`(notNullValue()))
            assertThat(objectDetailBean, equalTo(detailBeans[index]))
        }
        assertThat(storedObjectBeanMain.data, `is`(equalTo(objectBeanMain.data)))
    }

}