//
//  ViewController.swift
//  TabBar
//
//  Created by estgames on 2017. 12. 18..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        let title = UILabel(frame: CGRect(x: 0, y: 100, width: 100, height: 30))
        
        title.text = "첫번째 탭"
        title.textColor = UIColor.red
        title.textAlignment = .center
        title.font = UIFont.boldSystemFont(ofSize: 14)
        
        title.sizeToFit()
        
        title.center.x = self.view.frame.width / 2
        
        self.view.addSubview(title)
        
//        self.tabBarItem.image = UIImage(named: "calendar")
//        self.tabBarItem.title = "Calendar"
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

