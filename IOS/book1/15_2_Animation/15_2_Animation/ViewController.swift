//
//  ViewController.swift
//  15_2_Animation
//
//  Created by estgames on 2017. 12. 12..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var seal: UIImageView!
    
    @IBAction func tapView(_ sender: UITapGestureRecognizer) {
        let tapPoint = sender.location(in: view)
        UIView.animate(withDuration: 1.0, delay: 0, options: [.curveEaseInOut], animations: {self.seal.center = tapPoint}, completion: nil)
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

