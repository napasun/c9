//
//  ViewController.swift
//  uiSlider
//
//  Created by estgames on 2017. 12. 8..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var flower: UIImageView!
    @IBAction func changeSlider(_ sender: UISlider) {
        flower.alpha = CGFloat(sender.value)
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

