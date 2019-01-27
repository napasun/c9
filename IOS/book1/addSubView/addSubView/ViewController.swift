//
//  ViewController.swift
//  addSubView
//
//  Created by estgames on 2017. 12. 11..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        
        let labelA = UILabel()
        labelA.text = "라벨A"
        
        labelA.frame = CGRect(x: 80, y: 150, width: 110, height: 21)
        labelA.backgroundColor = UIColor.orange
        labelA.textColor = UIColor.white
        
        //뷰에 추가
        //self.view 루트뷰
        self.view.addSubview(labelA)
        
        let theView = UIView()
        
        theView.frame = CGRect(x: 60, y: 100, width: 210, height: 200)
        theView.backgroundColor = UIColor(displayP3Red: 0.9, green: 0.9, blue: 0.6, alpha: 1.0)
        
        let labelB = UILabel()
        labelB.text = "라벨B"
        
        labelB.frame = CGRect(x: 50, y: 60, width: 110, height: 21)
        labelB.backgroundColor = UIColor.orange
        labelB.textColor = UIColor.white
        
        theView.addSubview(labelB)
        self.view.addSubview(theView)
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

