//
//  ReadViewController.swift
//  InputForm
//
//  Created by estgames on 2017. 12. 18..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ReadViewController: UIViewController {
    var pEmail: String?
    var pUpdate: Bool?
    var pInterval: Double?
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        self.view.backgroundColor = UIColor.white
        
        let email = UILabel()
        let update = UILabel()
        let interval = UILabel()
        
        email.frame = CGRect(x: 50, y: 100, width: 300, height: 30)
        update.frame = CGRect(x: 50, y: 150, width: 300, height: 30)
        interval.frame = CGRect(x: 50, y: 200, width: 300, height: 30)
        
        email.text = "\(self.pEmail!)"
        update.text = "\(self.pUpdate == true ? "업데이트 함" :"업데이트 안함")"
        interval.text = "\(self.pInterval! ) 분마다"
        
        self.view.addSubview(email)
        self.view.addSubview(update)
        self.view.addSubview(interval)
    
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

}
