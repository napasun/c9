//
//  ToDoItem.swift
//  bookEx
//
//  Created by estgames on 12/11/2018.
//  Copyright © 2018 estgames. All rights reserved.
//

import Foundation

struct ToDoItem {
    let title:String
    let itemDescription: String?
    let timestamp: Double?
    let location: Location?
    
    init(title: String,
         itemDescription: String? = nil,
         timestamp: Double? = nil,
         location:Location? = nil) {
        
        
        self.title = title
        self.itemDescription = itemDescription
        self.timestamp = timestamp
        self.location = location
    }
}
