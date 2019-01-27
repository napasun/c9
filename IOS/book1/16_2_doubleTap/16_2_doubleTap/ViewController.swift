//
//  ViewController.swift
//  16_2_doubleTap
//
//  Created by estgames on 2017. 12. 13..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBAction func doubleTabFlower(_ sender: UITapGestureRecognizer) {
        let flower = sender.view!
        
        if flower.transform.isIdentity {
            flower.transform = CGAffineTransform(scaleX: 3, y: 3)
        } else {
            flower.transform = CGAffineTransform.identity
        }
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

