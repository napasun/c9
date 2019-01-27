//
//  ViewController.swift
//  13_6_uiScrollView
//
//  Created by estgames on 2017. 12. 11..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var myScrollView: UIScrollView!
    @IBOutlet weak var contentView: UIView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        let scrollFrame = CGRect(x: 0, y: 20, width: view.frame.width, height: view.frame.height-20)
        myScrollView.frame = scrollFrame
        
        let contentRect = contentView.bounds
        myScrollView.contentSize = CGSize(width: contentRect.width, height: contentRect.height)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

