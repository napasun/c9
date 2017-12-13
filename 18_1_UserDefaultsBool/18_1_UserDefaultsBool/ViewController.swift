//
//  ViewController.swift
//  18_1_UserDefaultsBool
//
//  Created by estgames on 2017. 12. 13..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var switch1: UISwitch!
    @IBOutlet weak var switch2: UISwitch!
    
    
    @IBAction func save(_ sender: Any) {
        let defaults = UserDefaults.standard
        
        defaults.set(switch1.isOn, forKey: "switchOn")
    }
    
    @IBAction func read(_ sender: Any) {
        let defaults = UserDefaults.standard
        
        switch2.isOn = defaults.bool(forKey: "switchOn")
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

