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
        
        let tapGesture = UITapGestureRecognizer(target: self, action: #selector(self.hello(_:)))
        
        let myView = UIView(frame: CGRect(x: 100, y: 100, width: 80, height: 80))
        myView.backgroundColor = UIColor.green
        
        myView.tag = 1
        myView.addGestureRecognizer(tapGesture)
        view.addSubview(myView)
    }
    
    @objc func hello (_ sender:UITapGestureRecognizer) {
        let tagNo = sender.view?.tag
        print("gg", tagNo!)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

