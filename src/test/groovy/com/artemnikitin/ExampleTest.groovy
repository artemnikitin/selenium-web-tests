package com.artemnikitin

import com.artemnikitin.pageobject.MainPage
import com.artemnikitin.pageobject.PostPage
import spock.lang.Specification

class ExampleTest extends Specification {

    def "Open main page and click on post to see it content"() {
        given: "Main page"
            MainPage page = new MainPage()
        expect: "Main page should be opened"
            page.opened

        when: "I get list of post on main page"
            def list = page.listOfPosts
        then: "And check that number of posts per page equals to 5"
            list.size() == 5

        when: "I click on post"
            PostPage post = page.openPost()
        then: "And check that page with post is opened"
            post.opened
    }

}
