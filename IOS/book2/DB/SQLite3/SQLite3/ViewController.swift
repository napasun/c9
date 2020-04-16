//
//  ViewController.swift
//  SQLite3
//
//  Created by estgames on 2018. 1. 3..
//  Copyright © 2018년 estgames. All rights reserved.
//

import UIKit
import SQLite3

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        var db: OpaquePointer? = nil
        var stmt: OpaquePointer? = nil
        
        let fileMgr = FileManager()
        let docPathURL = fileMgr.urls(for: .documentDirectory, in: .userDomainMask).first!
        let dbPath = docPathURL.appendingPathComponent("db.sqlite").path
        
        let sql = "CREATE TABLE IF NOT EXISTS sequence (num INTEGER)"
        
        if sqlite3_open(dbPath, &db) == SQLITE_OK {
            if sqlite3_prepare(db, sql, -1, &stmt, nil) == SQLITE_OK {
                if sqlite3_step(stmt) == SQLITE_DONE {
                    print("Create Table Success")
                }
                sqlite3_finalize(stmt)
            } else {
                print("Prepare Statement Fail")
            }
            sqlite3_close(db)
        } else {
            print("Database Connect Fail")
            return
        }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

