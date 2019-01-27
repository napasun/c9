//
//  ToDoItemTests.swift
//  bookExTests
//
//  Created by estgames on 12/11/2018.
//  Copyright © 2018 estgames. All rights reserved.
//

import XCTest
@testable import bookEx

class ToDoItemTests: XCTestCase {

    override func setUp() {
        // Put setup code here. This method is called before the invocation of each test method in the class.
    }

    override func tearDown() {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
    }

//    func testExample() {
//        // This is an example of a functional test case.
//        // Use XCTAssert and related functions to verify your tests produce the correct results.
//    }
//
//    func testPerformanceExample() {
//        // This is an example of a performance test case.
//        self.measure {
//            // Put the code you want to measure the time of here.
//        }
//    }
    func test_Init_TakesTitle() {
        let item = ToDoItem(title: "Foo")
        XCTAssertNotNil(item, "item should not be nil")
    }
    
    func test_Init_TakesTitleAndDescription() {
        _ = ToDoItem(title: "Foo",
                     itemDescription: "Bar")
    }
    
    func test_Init_WhenGivenTitle_SetsTitle() {
        let item = ToDoItem(title: "Foo")
        XCTAssertEqual(item.title, "Foo",
                       "should set title")
    }
    
    func test_Init_WhenGivenDescription_SetsDescription() {
        let item = ToDoItem(title: "",
                            itemDescription: "Bar")
        XCTAssertEqual(item.itemDescription, "Bar",
                       "should set itemDescription")
    }
    
    func test_Init_SetsTimestamp() {
        let item = ToDoItem(title: "",
                            timestamp: 0.0)
        
        XCTAssertEqual(item.timestamp, 0.0,
                       "should set timestamp")
    }
    
    func test_Init_WhenGivenLocation_SetsLocation() {
        let location = Location(name: "Foo")
    }
    
    func test_Init_SetsLocation() {
        
        let location = Location(name: "Foo")
        let item = ToDoItem(title: "",
                            location: location)
        
        XCTAssertEqual(item.location?.name,
                       location.name,
                       "should set location")
    }
}
