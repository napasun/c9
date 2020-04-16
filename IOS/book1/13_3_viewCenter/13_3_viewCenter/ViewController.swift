//
//  ViewController.swift
//  13_3_viewCenter
//
//  Created by estgames on 2017. 12. 11..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var myCar: UIImageView!
    let homePoint = CGPoint(x: 100, y: 150)
    
    
    @IBAction func goHome(_ sender: Any) {
        myCar.center = CGPoint(x: 100, y: 150)
    }
    
    @IBAction func move(_ sender: Any) {
        myCar.center.x += 10
    }
    
    override func viewDidLayoutSubviews() {
        // 화면으로의 배치 완료와 동시에 좌표설정
        myCar.center = homePoint
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

