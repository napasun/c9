//
//  ViewController.swift
//  uiLabel_text
//
//  Created by estgames on 2017. 12. 7..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var myLabel1: UILabel!
    @IBOutlet weak var myLabel2: UILabel!
    @IBOutlet weak var myLabel3: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        let unitPrice = 1200
        let quantity = 4
        
        myLabel1.text = "단가 \(unitPrice), \(quantity)개"
        myLabel1.textAlignment = .left
        myLabel1.textColor = UIColor.yellow
        myLabel1.backgroundColor = UIColor.black
        
        myLabel2.text = String(unitPrice*quantity)
        myLabel2.textAlignment = .center
        myLabel3.text = "금액 " + myLabel2.text! + "원"
        myLabel3.textAlignment = .right
        
        
        let myLabel4 = UILabel()
        myLabel4.text = "헬로 월드"
        
        myLabel4.frame = CGRect(x: 50, y: 100, width: 200, height: 21)
        view.addSubview(myLabel4)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

