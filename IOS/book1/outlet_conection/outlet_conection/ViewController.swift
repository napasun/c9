//
//  ViewController.swift
//  outlet_conection
//
//  Created by estgames on 2017. 12. 7..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var myLabel: UILabel!
    
    
    @IBAction func hello(_ sender: Any) {
        myLabel.text = "Hello"
    }
    
    @IBAction func thank(_ sender: Any) {
        myLabel.text = "thank"
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

