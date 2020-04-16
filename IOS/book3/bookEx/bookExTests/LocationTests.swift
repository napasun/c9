//
//  LocationTests.swift
//  bookExTests
//
//  Created by estgames on 14/11/2018.
//  Copyright © 2018 estgames. All rights reserved.
//

import XCTest

class LocationTests: XCTestCase {
    func test_Init_SetsCoordinate() {
        let coordinate =
            CLLocationCoordinate2D(latitude: 1,
                                   longitude: 2)
        
        
        let location = Location(name: "",
                                coordinate: coordinate)
        
        
        XCTAssertEqual(location.coordinate?.latitude,
                       coordinate.latitude)
        XCTAssertEqual(location.coordinate?.longitude,
                       coordinate.longitude)
    }
}
