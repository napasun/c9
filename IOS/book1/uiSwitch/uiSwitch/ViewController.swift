//
//  ViewController.swift
//  uiSwitch
//
//  Created by estgames on 2017. 12. 8..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var msgLabel: UILabel!
    @IBAction func showHide(_ sender: UISwitch) {
        msgLabel.isHidden = !sender.isOn
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

