//
//  ViewController.swift
//  16_1_GestureRecognizerTap
//
//  Created by estgames on 2017. 12. 13..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var dragonfly: UIImageView!
    @IBAction func tapDragonfly(_ sender: UITapGestureRecognizer) {
        //let dragonfly = sender.view!
        
        let newX = arc4random_uniform(UInt32(view.frame.width))
        let newY = arc4random_uniform(UInt32(view.frame.height))
        
        dragonfly.center = CGPoint(x: Double(newX), y: Double(newY))
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

