//
//  ViewController.swift
//  16_3_PenDrag
//
//  Created by estgames on 2017. 12. 13..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBAction func dragging(_ sender: UIPanGestureRecognizer) {
        let dragonfly = sender.view!
        
        dragonfly.center = sender.location(in: view)    //드래그한 양을 알아낸다
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

