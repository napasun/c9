//
//  ViewController.swift
//  13_3_viewFrame
//
//  Created by estgames on 2017. 12. 11..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var myPhoto: UIImageView!
    
    @IBAction func changedFrame(_ sender: UISegmentedControl) {
        let index = sender.selectedSegmentIndex
        switch index {
        case 0 :
            myPhoto.frame = CGRect(x: 30, y: 100, width: 320, height: 240)
        case 1 :
            myPhoto.frame = CGRect(x: 110, y: 160, width: 160, height: 120)
        default :
            myPhoto.frame = CGRect(x: 30, y: 100, width: 320, height: 240)
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        myPhoto.contentMode = .scaleAspectFit   //화면에 맞게 크기 조절
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

