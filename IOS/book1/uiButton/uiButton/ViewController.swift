//
//  ViewController.swift
//  uiButton
//
//  Created by estgames on 2017. 12. 7..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var uiButton1: UIButton!
    @IBOutlet weak var uiButton2: UIButton!
    @IBOutlet weak var uiLabel1: UILabel!
    
    @IBAction func random(_ sender: Any) {
        let num = arc4random_uniform(100)
        uiLabel1.text = String(num)
        
        uiButton2.isEnabled = (num>=50)
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

